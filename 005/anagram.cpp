#include <string>
#include <iostream>
#include <string.h>

using namespace std;

int main()
{
	char a[10],b[10];
	int i,v[200]={0},w[200]={0},al,bl,ok=-1;
	cin>>a>>b;
	al=strlen(a);bl=strlen(b);
	if(al!=bl)
		cout<<"Not an anagram";
	else
	{
		for(i=0;i<al;i++)
			v[a[i]]++;
		for(i=0;i<bl;i++)
			w[b[i]]++;
		for(i=0;i<200;i++)
			if(v[i]!=w[i])
				ok=0;
		if(ok==0)cout<<"Yes";
		else if(ok==-1)cout<<"No";
	}
	return 0;
}
