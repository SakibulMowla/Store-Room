#include <stdio.h>
#include <string.h>
#include <string>
#include <stdlib.h>
#include <math.h>
#include <map>
#include <vector>
#include <queue>
#include <stack>
#include <set>
#include <iostream>
#include <algorithm>
#include <deque>
#include <assert.h>

//#include <bits/stdc++.h>

using namespace  std;

typedef long long ll;

void RD(int &x){scanf("%d",&x);}
void RD(ll &x){scanf("%lld",&x);}
void RD(double &x){scanf("%lf",&x);}
void RD(int &x,int &y){scanf("%d%d",&x,&y);}
void RD(ll &x,ll &y){scanf("%lld%lld",&x,&y);}
void RD(double &x,double &y){scanf("%lf%lf",&x,&y);}
void RD(char *s){scanf("%s",s);}
void RD(char &s){scanf("%c",&s);}
void RD(string &s){cin>>s;}

void PR(int x) {printf("%d\n",x);}
void PR(int x,int y) {printf("%d %d\n",x,y);}
void PR(ll x) {printf("%lld\n",x);}
void PR(char x) {printf("%c\n",x);}
void PR(char *x) {printf("%s\n",x);}
void PR(string x) {cout<<x<<endl;}

//inline void inp( int &n ){
//    n=0;
//    int ch=getchar_unlocked();int sign=1;
//    while( ch < '0' || ch > '9' ){if(ch=='-')sign=-1; ch=getchar_unlocked();}
//    while(  ch >= '0' && ch <= '9' )
//            n = (n<<3)+(n<<1) + ch-'0', ch=getchar_unlocked();
//    n=n*sign;
//}


#define clr(a) (a.clear())
#define MP(a,b) make_pair(a,b)
#define sz(x) (int)x.size()
#define mem(a,b) memset(a, b, sizeof(a))
#define Unique(store) store.resize(unique(store.begin(),store.end())-store.begin())
#define REP(i,n) for((i)=0;(i)<(int)(n);(i)++)
#define REP1(i,a,b) for((i)=a;(i)<=(int)(b);(i)++)
#define REP2(i,a,b) for((i)=a;(i)>=(int)(b);(i)--)
#define snuke(c, itr) for(__typeof((c).begin()) itr=(c).begin();itr!=(c).end();itr++)
#define pb push_back
#define ssort(a) stable_sort(a.begin(), a.end())

#define X first
#define Y second

//ll extGcd(ll a, ll b, ll& x, ll& y){if (b == 0){x = 1;y = 0;return a;}else{int g = extGcd(b, a % b, y, x);y -= a / b * x;return g;}}
//ll modInv(ll a, ll m){ll x, y; extGcd(a, m, x, y); x %= m; while (x < 0){x += m;} return x;}
//ll bigmod(ll a,ll b,ll m){if(b == 0) return 1%m;ll x = bigmod(a,b/2,m);x = (x * x) % m;if(b % 2 == 1) x = (x * a) % m;return x;}
//ll BigMod(ll B,ll P,ll M){     ll R=1%M; while(P>0)      {if(P%2==1){R=(R*B)%M;}P/=2;B=(B*B)%M;} return R;} /// (B^P)%M

//template <class T> T gcd(T a, T b){if(b == 0) return a;return gcd(b,a%b);}
//template <class T> T lcm(T a, T b){return (a/gcd(a,b)) * b;}

//ll x[] = {0,0,-1,1};//4-way
//ll y[] = {-1,1,0,0};//4-way
//ll x[] = {-1,-1,-1,0,0,1,1,1};//8-way
//ll y[] = {-1,0,1,-1,1,-1,0,1};//8-way

typedef pair<int , int> pii;
typedef pair<ll , ll> pll;
const int inf = 1;
const ll mod = 1LL;

#define SZ  50

int len, num[50];

void set_number(ll n){
    len = 0;
    mem(num, 0);
    while(n){
        num[++len] = n%2;
        n/=2;
    }
}

ll dp1[SZ][2], dp2[SZ][2];

ll solve2(int indx, int flag){
    if(indx == 0) return 1LL;

    ll &ret = dp2[indx][flag];
    if(~ret) return ret;

    int i, nflag, lim;
    ret = 0LL;
    lim = flag ? num[indx] : 1;

    for(i=0; i<=lim; i++){
        if(flag == 1 && i == lim) nflag = 1;
        else nflag = 0;
        ret += solve2(indx-1, nflag);
    }

    return ret;
}

ll solve1(int indx, int flag){
    if(indx <= 0) return 0LL;

    ll &ret = dp1[indx][flag];
    if(~ret) return ret;

    int i, nflag, lim;
    ret = 0LL;
    lim = flag ? num[indx] : 1;

    for(i=0; i<=lim; i++){
        if(flag == 1 && i == lim) nflag = 1;
        else nflag = 0;
        if(i == 1) ret += solve2(indx-1, nflag);
        ret += solve1(indx-1, nflag);
    }

    return ret;
}

double second(ll a, ll b){
    ll ans;
    double d;

    set_number(b);
    mem(dp1, -1);
    mem(dp2, -1);
    ans = solve1(len, 1);

    set_number(a-1);
    mem(dp1, -1);
    mem(dp2, -1);
    ans = ans - solve1(len, 1);

    d = (double)ans / (double)(b-a+1);
    return d;
}

ll cnt[SZ], two[SZ];

void cal(ll n, int mark){
    if(n == 0) return;

    int i;

    set_number(n);
    for(i=0; i<=40; i++) num[i] = 1;
    mem(dp1, -1);
    mem(dp2, -1);

    for(i=1; i<=len-1; i++){
        if(mark == 1) cnt[i] = solve1(i-1, 1) + solve2(i-1, 1);
        else cnt[i] -= (solve1(i-1, 1) + solve2(i-1, 1));
    }

    set_number(n);
    mem(dp1, -1);
    mem(dp2, -1);

    if(mark == 1) cnt[len] = solve1(len-1, 1) + solve2(len-1, 1);
    else cnt[len] -= (solve1(len-1, 1) + solve2(len-1, 1));
}

double first(ll a, ll b){
    int l, i;
    double d;

    mem(cnt, 0);
    cal(b, 1);
    l = len;

    cal(a-1, 2);

    d = 0;
    for(i=1; i<=l; i++){
        d += (double)cnt[i] / (double)i;
    }

    d = d / (double)(b-a+1);
    return d;
}

int main() {
    #if defined JESI
//        freopen("1.txt", "r", stdin);
//        freopen("3.txt", "w", stdout);
    #endif

    int t;
    ll a, b;

    RD(t);

    while(t--){
        RD(a, b);

        printf("%.5lf %.5lf\n",first(a, b), second(a, b));
    }

    return 0;
}













