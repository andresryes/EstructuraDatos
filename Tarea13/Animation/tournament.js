function* algorithm() {

    // graphics objects
    var box = algo.BOUNDS.inflate(-50, 0);
    box.x += 22;
    var graph = make_graph();
    var layout = new algo.layout.GraphDirected(graph);

    var i, j, k;

    for (i = 0; i < 32; i += 1)
        graph.addVertex({
            label: i
        }).element.set({
            state: algo.render.kS_NORMAL
        });
    var V = _.values(graph.vertices);
    V[0].element.set({
        opacity: 0
    });
    for (j = 2; j < 32; j += 1) {
        graph.addEdge(V[j >> 1], V[j]);
    }
    layout.update(box);

    var WORD = [];
    for (i = 0; i < 16; i += 1) {
        WORD.push(parseInt(Math.random() * 99) + 1);
    }
    var varray = makeArray();
    yield ({
        step: "The Segment Tree has been build on the array, but both data structures are empty."
    });

    for (i = 31; i > 0; i -= 1) {
            highlight(i, algo.render.kS_GREEN);
            if (i < 16) {
                highlight(i * 2, algo.render.kS_BLUE);
                highlight(i * 2 + 1, algo.render.kS_BLUE);
                V[i].element.set({
                    text: safeMin(V[i * 2].element.text, V[i * 2 + 1].element.text)
                });
            } else {
                varray.a[i - 16].element.set({
                    state: algo.render.kS_BLUE
                });
                V[i].element.set({
                    text: WORD[i - 16]
                });
            }

            yield ({
                step: "The value at each node is the minimum of its children's values."
            });

            highlight(i, algo.render.kS_NORMAL);
            if (i < 16) {
                highlight(i * 2, algo.render.kS_NORMAL);
                highlight(i * 2 + 1, algo.render.kS_NORMAL);
            } else {
                varray.a[i - 16].element.set({
                    state: algo.render.kS_NORMAL
                });
            }
        }

    yield ({});

    function safeMin(a, b) {
        if (a && b) return Math.min(a, b);
        if (a) return a;
        else return b;
    }

    function value(v) {
        return V[v].element.text;
    }

    function highlight(v, color) {
        V[v].element.set({
            state: color
        });
    }

    function highlight_parent(v, color) {
        if (v > 1) {
            _.values(graph.getEdges(V[v >> 1], V[v]))[0].element.set({
                state: color
            });
        }
    }

    function makeArray() {
        var bounds = algo.BOUNDS.inflate(-50, 0);
        bounds.y += 150;
        var kS = bounds.w / (WORD.length + 2);
        var layout = new algo.layout.GridLayout(bounds, 1, WORD.length);


        return new algo.core.Array({
            data: WORD,
            createElement: _.bind(function(value, index) {
                var element = new algo.render.LetterTile({
                    text: WORD[index],
                    w: kS,
                    h: kS * 1.5,
                    value: index
                });
                element.layout(layout.getBox(0, index));

                return element;

            }, this),

            swapElement: _.bind(function(value, newIndex, oldIndex, element) {
                var newCell = layout.getBox(0, newIndex),
                    oldCell = layout.getBox(0, oldIndex);
                var newX = newCell.cx - element.w / 2,
                    oldX = oldCell.cx - element.w / 2;
                var H = element.h * 1.5,
                    Y = element.y;
                var yoffset = oldIndex < WORD.length / 2 ? H : -H;

                element.set({
                    y: [Y + yoffset, Y + yoffset, Y],
                    x: [oldX, newX, newX],
                    state: [algo.render.kS_BLUE, algo.render.kS_BLUE, algo.render.kS_FADED]
                });
            })
        });
    }

    function make_graph() {
        return new algo.core.Graph({
            createVertex: function(vertex, gfd) {
                return new algo.render.Circle({
                    //text: "∞",
                    strokeWidth: 1,
                    radius: 16,
                    fontSize: 14,
                    z: 100
                });
            },
            createEdge: function(edge, gfd) {
                return new algo.render.Arrow({
                    startArrow: false,
                    endArrow: false
                });
            },
            updateVertex: function(vertex, element, center, gfd) {
                element.set({
                    x: center.x,
                    y: center.y
                });
            },
            updateEdge: function(edge, element, start, end, gfd) {
                // get a line connecting the circumference of each vertex element (which are circles )
                var lineSegment = algo.layout.Line.getConnector(edge.source.element, edge.target.element);
                element.set({
                    shape: lineSegment
                });
            }
        });
    }
}