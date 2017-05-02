#include <iostream>

using namespace std;

int main()
{
	int a,b,n;
	cin>>a>>b;
	while(a!=0)
	{
		n=n*10+a%10;
		a/=10;
	}
	if(n==b)
		cout<<"Yes";
	else cout<<"No";
	return 0;
}
