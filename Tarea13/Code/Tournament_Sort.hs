import Data.Tree


-- | Adapted from `TOURNAMENT-SORT!` in the Stepanov and Kershenbaum report.
tournamentSort :: Ord t
       => [t]  -- ^ Input: an unsorted list
       -> [t]  -- ^ Result: sorted version of the input
tournamentSort alist
        = go (pure<$>alist) -- first, wrap each element as a single-tree forest
 where go [] = []
       go trees = (rootLabel winner) : (go (subForest winner))
        where winner = playTournament trees


-- | Adapted from `TOURNAMENT!` in the Stepanov and Kershenbaum report
playTournament :: Ord t
         => Forest t -- ^ Input forest
         -> Tree t   -- ^ The last promoted tree in the input
playTournament [tree] = tree
playTournament trees = playTournament (playRound trees [])


-- | Adapted from `TOURNAMENT-ROUND!` in the Stepanov and Kershenbaum report
playRound :: Ord t
       => Forest t -- ^ A forest of trees that have not yet competed in round
       -> Forest t -- ^ A forest of trees that have won in round
       -> Forest t -- ^ Output: a forest containing promoted versions
                   --   of the trees that won their games
playRound [] done = done
playRound [tree] done = tree:done
playRound (tree0:tree1:trees) done = playRound trees (winner:done)
 where winner = playGame tree0 tree1


-- | Adapted from `TOURNAMENT-PLAY!` in the Stepanov and Kershenbaum report
playGame :: Ord t
         => Tree t  -- ^ Input: ...
         -> Tree t  -- ^ ... two trees
         -> Tree t  -- ^ Result: `promote winner loser`, where `winner` is
                    --   the tree with the *lesser* root of the two inputs
playGame tree1 tree2
    | rootLabel tree1 <= rootLabel tree2  = promote tree1 tree2
    | otherwise                           = promote tree2 tree1


-- | Adapted from `GRAB!` in the Stepanov and Kershenbaum report
promote :: Tree t  -- ^ The `winner`
        -> Tree t  -- ^ The `loser`
        -> Tree t  -- ^ Result: a tree whose root is the root of `winner`
                   --   and whose children are:
                   --   * `loser`,
                   --   * all the children of `winner`
promote winner loser = Node {
    rootLabel = rootLabel winner,
    subForest = loser : subForest winner}


main :: IO ()
main = print $ tournamentSort testList
 where testList = [-0.202669, 0.969870, 0.142410, -0.685051, 0.487489, -0.339971, 0.832568, 0.00510796, -0.822352, 0.350187, -0.477273, 0.695266]