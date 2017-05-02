#include <iostream>

using namespace std;

int main()
{
	float kg, cm;
	cout<<"Weight (kilograms):";
	cin>>kg;
	cout<<"Height (centimeters):";
	cin>>cm;
	cm/=100;
	cout<<kg/(cm*cm);
	return 0;
}
