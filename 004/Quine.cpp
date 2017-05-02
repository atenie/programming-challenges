#include <iostream>
#include <string.h>

using namespace std;

int main()
{
	string l[12]={
"	",
"#include <iostream>",
"#include <string.h>",
"	",
"using namespace std;",
"int main()",
"{",
"	string l[]={};",
"	for(int i=0;i<34;i++)",
"		cout<<l[i];",
"	return 0;",
"}"};
	for(int i=0;i<12;i++)	
		cout<<l[i]<<endl;
	return 0;
}

