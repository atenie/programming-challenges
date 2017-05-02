#include<iostream>

using namespace std;

void afisare(int v[9][9], int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            cout<<" "<<v[i][j];
        cout<<endl;
    }
}

int verificare(int v[9][9], int l, int c, int N)
{
    int i, j;
 
    //verifica linia in stanga
    for (i = 0; i < c; i++)
        if (v[l][i])
            return 0;
 
    //verifica diagonala superioara in stanga
    for (i=l, j=c; i>=0 && j>=0; i--, j--)
        if (v[i][j])
            return 0;
 
    //verifica diagonala inferioara in stanga
    for (i=l, j=c; j>=0 && i<N; i++, j--)
        if (v[i][j])
            return 0; 
    return 1;
}

int rezolvare(int v[9][9], int c, int N)
{
    if (c >= N)
        return 1;
    for (int i = 0; i < N; i++)
    {
        if ( verificare(v, i, c, N) )
        {
            v[i][c] = 1;
            if ( rezolvare(v, c + 1,N) )
                return 1;
            v[i][c] = 0; // reluam
        }
    }
    return 0;
}

int main()
{
    int v[9][9] = {0}, N;
    cin>>N;
    if ( rezolvare(v, 0, N) == 0 )
    {
      cout<<"Nu exista";
      return 0;
    }
    afisare(v,N);
    return 0;
}
