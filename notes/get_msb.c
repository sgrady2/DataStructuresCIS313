#include <stdio.h>

int get_msb(int x)
{
	 int shift_val = (sizeof(int)-1)<<3;
	 int xright = x >> shift_val;
	 return xright & 0xFF;
}

int main()
{
	unsigned x = 15;
	int y = get_msb(x);
	x = x>>2;
	printf("xtostring: %d\n", x);





}