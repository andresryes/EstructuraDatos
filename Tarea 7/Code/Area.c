#include <stdio.h>
#include <math.h>

//const double PI = 3.14159265358979323846264338327;
const double PI = 3.1416;

struct Circle {
    int radio;
};  

float calculateArea(struct Circle circle)
{
    return PI*(circle.radio*circle.radio);
}

void unitTest()
{
    int input = 15;
    struct Circle circleTest;
    circleTest.radio = input;

    float resultTest = (calculateArea(circleTest));
    if(resultTest == 706.859985){
        printf("correct");
    }else{
        printf("test fallido");
    }
}

int main(void)
{
    printf("Hello! This is a test program.\n");
    struct Circle circle1;
    circle1.radio = 1;
    printf("Area : %lf\n", calculateArea(circle1));
    int a;
    scanf("%d", &a);*/
    return 0;
}
