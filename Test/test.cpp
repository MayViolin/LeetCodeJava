#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main()
{
	int testnum;
	cin >> testnum; /.1
	int **p = NULL;
	p = new int* [testnum];
	int *n = new int [testnum];
	for (int i = 0; i < testnum; i++)
	{
		int mnum, snum;
		cin >> mnum >> snum; /.2
		n[i] = mnum;
		p[i] = new int[mnum];
		for(int j = 0; j < mnum; j++)
		{
			p[i][j] = 0;
		}
		queue<int> squeue;
		for(int j = 0; j < snum; j++)
		{
			int a;
			cin >> a; /.3
			squeue.push(a);
		}
		int *start = new int [mnum];
		vector<vector<int> > product;
		for(int j = 0; j < mnum; j++)
		{
			cin >> start[j]; /.4[1]
			int b;
			cin >> b;/.4[2]
			vector<int> productj;
			for(int k = 0; k < b; k++)
			{
				int s;
				cin >> s;/.4
				productj.push_back(s);
			}
			product.push_back(productj);
		}
		for (int j = 0; j < product.size(); j++)
		{
			for (int k = 0; k < product[j].size(); k++)
			{
				for (int m = 0; m < mnum; m++)
				{
					if (product[j][k] == start[m])
					{
						break;
					}
					if (m == mnum - 1)
					{
						product[j].erase(product[j].begin() + k);
						k--;
					}
				}
			}
		}
		while (!squeue.empty())
		{
			int signal = squeue.front();
			for(int j = 0; j < mnum; j++)
			{
				if(signal == start[j])
				{
					p[i][j] ++;
					for(int k = 0; k < product[j].size(); k++)
					{
						squeue.push(product[j][k]);
					}
				}
			}
			squeue.pop();
		}
	}
	for(int i = 0; i < testnum; i++)
	{
		for (int j = 0; j < n[i]; j++)
		{
			cout << p[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}
