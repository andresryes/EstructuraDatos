#include <stdio.h>
#include <math.h>

//const double PI = 3.14159265358979323846264338327;
typedef union FigureArea{
    int figureID;
    float area;
}FigureArea;

const double PI = 3.1416;

typedef struct Shape{ //1 circle, 2 rectangle, 3 triangle
    union FigureArea area;
    float size1;
    float size3;
    float size2;
}Shape;

float calculateArea(struct Shape figure)
{
    float floatToReturn = 0;
    if(figure.area.figureID == 1){
        floatToReturn = PI*(figure.size1*figure.size1);
    }

    if(figure.area.figureID == 2){
        floatToReturn = figure.size1*figure.size2;
    }

    if(figure.area.figureID == 3){
        float p = (figure.size1+figure.size2+figure.size3)/2;
        floatToReturn = sqrt(( p*(p-figure.size1)*(p-figure.size2)*(p-figure.size3)));
    }
    return floatToReturn;
};

void unitTest()
{
    int input = 1;
    struct Shape circleTest;
    circleTest.area.figureID = input;

    float resultTest = (calculateArea(circleTest));
    if(resultTest == 706.859985){
        printf("correct");
    }else{
        printf("test fallido");
    }
}

int main(void)
{   
    int input = 1;
    printf("Hello! This is a test program.\n");
    struct Shape circle1;
    circle1.area.figureID = input;
    circle1.size1 = 15;
    circle1.area.area = calculateArea(circle1);
    printf("Area : %lf\n", circle1.area.area);
    int a;
    scanf("%d", &a);
    return 0;
}
