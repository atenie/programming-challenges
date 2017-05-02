#include <iostream>

using namespace std;

int main()
{
	int i;
	char s[6];
	cin>>s;
	for(i=0;i<6;i++)
		if((s[i]<='a' && s[i]<='m')||(s[i]>='A' && s[i]<='m'))
			s[i]+=13;
		else if((s[i]>='n' && s[i] <='z')||(s[i]>='N' && s[i]<='Z'))
			s[i]-=13;
	cout<<s;
	return 0;
}
