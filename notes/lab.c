//Lab 314 
#include <stdio.h>
#include <stdlib.h>



typedef struct Books
{
	char* title;
	char* author;
	char* subject;
	int book_id;
	Book *next;
}Book;

int main(){
	//pointer to the struct Books called Book
	Book *p = malloc(sizeof(Book));
	//this next line gives a pointer to a pointer
	//p->title="C programming";
	p->title="C programming";
	p->author ="Klien";
	p->subject="Computer";
	p->book_id=23433;

	printf("t:%s\n",p->title);
	printf("author:%s\n",p->author);
	printf("subject:%s\n",p->subject);
	printf("book_id:%d\n",p->book_id);

	free(p);
	
}