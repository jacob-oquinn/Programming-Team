
#include <bits/stdc++.h>

using namespace std;

#define MAX 1002
#define MOD 10007

int ans[MAX];

int rec(int l) {
	if (l < 0) return 1;
	if (ans[l] != -1) return ans[l];
	ans[l] = 0;
	for (int i = 1; i <= l; i++) {
		ans[l] += rec(l - i - 1);
		if (i * 2 >= l && i < l - 1)
			ans[l]++;
	}
	ans[l] %= MOD;
	return ans[l];
}

int main() {
	for (int i = 0; i < MAX; i++)
		ans[i] = -1;
	ans[0] = ans[1] = 1;
	int t;
	cin >> t;
	while (t--) {
		int s, l;
		cin >> s >> l;
		cout << s << " " << rec(l+1) << endl;
	}
	return 0;
}