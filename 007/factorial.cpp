#include <iostream>

using namespace std;

int main()
{
	int n,f=1;
	cin>>n;
	while(n)
	{
		f*=n;
		n--;
	}
	cout<<f;
	return 0;
}
