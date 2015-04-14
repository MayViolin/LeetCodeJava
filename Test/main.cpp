#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main()
{
	int examples;
	cin >> examples;
	int **p = NULL;
	p = new int* [examples];
	int *n = new int [examples];
	for (int i = 0; i < examples; i++)
	{
		int modules, signals;
		cin >> modules >> signals;
		n[i] = modules;
		p[i] = new int[modules];
		for(int j = 0; j < modules; j++)
		{
			p[i][j] = 0;
		}
		queue<int> signalQ;
		for(int j = 0; j < signals; j++)
		{
			int elem;
			cin >> elem;
			signalQ.push(elem);
		}
		int *start = new int [modules];
		vector<vector<int> > product;
		for(int j = 0; j < modules; j++)
		{
			cin >> start[j];
			int b;
			cin >> b;
			vector<int> productj;
			for(int k = 0; k < b; k++)
			{
				int s;
				cin >> s;
				productj.push_back(s);
			}
			product.push_back(productj);
		}
		for (int j = 0; j < product.size(); j++)
		{
			for (int k = 0; k < product[j].size(); k++)
			{
				for (int m = 0; m < modules; m++)
				{
					if (product[j][k] == start[m])
					{
						break;
					}
					if (m == modules - 1)
					{
						product[j].erase(product[j].begin() + k);
						k--;
					}
				}
			}
		}
		while (!signalQ.empty())
		{
			int signal = signalQ.front();
			for(int j = 0; j < modules; j++)
			{
				if(signal == start[j])
				{
					p[i][j] ++;
					for(int k = 0; k < product[j].size(); k++)
					{
						signalQ.push(product[j][k]);
					}
				}
			}
			signalQ.pop();
		}
	}
	for(int i = 0; i < examples; i++)
	{
		for (int j = 0; j < n[i]; j++)
		{
			cout << p[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}

