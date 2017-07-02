#include<iostream>

using namespace std;

void print(int v[9][9], int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            cout<<" "<<v[i][j];
        cout<<endl;
    }
}

int verify(int v[9][9], int l, int c, int N)
{
    int i, j;
 
    //check the line in the left
    for (i = 0; i < c; i++)
        if (v[l][i])
            return 0;
 
    //check the superior diagonal in the left
    for (i=l, j=c; i>=0 && j>=0; i--, j--)
        if (v[i][j])
            return 0;
 
    //check the inferior diagonal in the left
    for (i=l, j=c; j>=0 && i<N; i++, j--)
        if (v[i][j])
            return 0; 
    return 1;
}

int solve(int v[9][9], int c, int N)
{
    if (c >= N)
        return 1;
    for (int i = 0; i < N; i++)
    {
        if ( verify(v, i, c, N) )
        {
            v[i][c] = 1;
            if ( solve(v, c + 1,N) )
                return 1;
            v[i][c] = 0; // we go again
        }
    }
    return 0;
}

int main()
{
    int v[9][9] = {0}, N;
    cin>>N;
    if ( solve(v, 0, N) == 0 )
    {
      cout<<"Does not exist";
      return 0;
    }
    print(v,N);
    return 0;
}
