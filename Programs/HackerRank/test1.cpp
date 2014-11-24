#undef NDEBUG
#ifdef ssu1
#define _GLIBCXX_DEBUG
#endif

#include <algorithm>
#include <functional>
#include <numeric>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cstring>
#include <cassert>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <queue>
#include <bitset>
#include <sstream>

using namespace std;

#define fore(i, l, r) for(int i = int(l); i < int(r); ++i)
#define forn(i, n) fore(i, 0, n)
#define fori(i, l, r) fore(i, l, (r) + 1)
#define sz(v) int((v).size())
#define all(v) (v).begin(), (v).end()
#define pb push_back
#define mp make_pair
#define X first
#define Y second

template<typename T> inline T abs(T a){ return ((a < 0) ? -a : a); }
template<typename T> inline T sqr(T a){ return a * a; }

typedef long long li;
typedef long double ld;
typedef pair<int, int> pt;

int sum(vector<int>& a, int l, int r){
    if(l < 0)
        l = 0;
    if(r >= sz(a))
        r = sz(a) - 1;
    if(l > r)
        return 0;
    return a[r] - (l == 0 ? 0 : a[l - 1]);
}

int main() {
#ifdef ssu1
    assert(freopen("input.txt", "rt", stdin));
#endif
    string a, b;
    cin >> a >> b;

    reverse(all(a));
    reverse(all(b));

    const int n = 314159;
    const int NMAX = int(1e6);
    const int mod = int(1e9) + 7;

    vector<int> pw2(NMAX);
    pw2[0] = 1;
    fore(i, 1, NMAX)
        pw2[i] = (int)((pw2[i - 1] * 2LL) % mod);

    vector<int> sb(sz(b));
    forn(i, sz(b)){
        sb[i] = b[i] - '0';
        if(i > 0)
            sb[i] += sb[i - 1];
    }

    int ans = 0;
    forn(i, NMAX){
        int start = (i >= sz(a) ? 0 : a[i] - '0'), cnt = sum(sb, i - n, i);
        if(start == 1){
            ans = (int)((ans + (n + 1 - cnt) * 1LL * pw2[i]) % mod);
        }else{
            ans = (int)((ans + cnt * 1LL * pw2[i]) % mod);
        }
//        printf("cnt %d\n",cnt);
    }
    cout << ans << endl;
#ifdef ssu1
    cerr << "\nTime = " << double(clock()) / CLOCKS_PER_SEC << endl;
#endif
    return 0;
}
