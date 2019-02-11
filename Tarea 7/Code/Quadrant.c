#include <stdio.h>
#include <math.h>

struct Point {
    int x;
    int y;
};  

int determineQuadrant(struct Point point)
{
    int intToReturn = 0;
    if(point.x>=0){
        if(point.y>=0){
            intToReturn = 1;
        }else{
            intToReturn = 4;
        }
    }else{
        if(point.y>=0){
            intToReturn = 2;
        }else{
            intToReturn = 3;
        }
    }

    return intToReturn;
}

void unitTest()
{
    int input1 = -5;
    int input2 = -10;

    struct Point pointTest;
    pointTest.x = input1;
    pointTest.y = input2;

    if(determineQuadrant(pointTest) == 3){
        printf("correct");
    }else{
        printf("incorrect");
    }
}

int main(void)
{
    printf("Hello! This is a test program.\n");

    struct Point point;
    point.x = -1;
    point.y = 1;

    printf("Quadrant : %d\n", determineQuadrant(point));
    //unitTest();
    int a;
    scanf("%d", &a);

    return 0;
}
