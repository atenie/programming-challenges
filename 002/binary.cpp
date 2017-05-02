#include <iostream>

using namespace std;

int main()
{
	int n,x,v[10],i,j,ok;
	cin>>x>>n;
	for(i=0;i<n;i++)
		cin>>v[i];
	i=0;
	j=n-1;
	ok=0;
	while(i<=j && !ok)
	{
		if(x==v[(i+j)/2])
		{
			cout<<"found in this position "<<(i+j)/2;
			ok=1;
		}
		else if(x>v[(i+j)/2])
			i=((i+j)/2)+1;
		else j=((i+j)/2)-1;
	}
	if(!ok)
		cout<<"does not exist";
	return 0;
}
/* We have a vector with its elements in ascending order.
 * We process the vector using i(0) and j(n). 
 * Using the middle value ((i+j)/2) we replace either i or j.
 * We repeat this halfing process until we get to the final result.
 */
