#include <iostream>

using namespace std;

int main()
{
	int n,x,b,p;
	cin>>x>>b;
	n=0;
	p=1;
	while(x>=b)
	{
		n+=p*(x%b);
		p*=10;
		x/=b;
	}
	n=n+p*x;
	cout<<n;
	return 0;
}
