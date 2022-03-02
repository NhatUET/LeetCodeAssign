#include<bits/stdc++.h>
using namespace std;
void bt(string tiles, string res, set<string>& fi, int k) {
    if (k >= tiles.size()) return;
    for (int i = k; i < tiles.size(); i++) {
        res.push_back(tiles[i]);
        fi.insert(res);
        bt(tiles, res,fi,k+1);
        res = "";
    }
}
int numTilePossibilities(string tiles) {
    string res;
    set<string> fi;
    bt(tiles, res, fi, 0);
    return fi.size()+1;
}
int main() {
    string s = "AAB";
    cout << numTilePossibilities(s) << endl;
    return 0;
}
