// 파일 정리
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    vector<string> files;
    vector<string> extension;

    cin >> input;
    for(int i = 0; i < input; i++) {
        string temp;
        cin >> temp;

        files.push_back(temp);
    }

    for(int i = 0; i < input; i++) {
        int index;
        for(int j = files[i].length() - 1; j >= 0; j--) {
            if(files[i].at(j) == '.') {
                index = j + 1;
                break;
            }
        }
        extension.push_back(files[i].substr(index, files[i].length()));
    }

    sort(extension.begin(), extension.end());


    int count = 1;
    string st = extension[0];
    for(int i = 1; i < extension.size() - 1; i++) {
        if(st == extension[i]) {
            count++;
        }
        else {
            cout << st << ' ' << count << '\n';
            st = extension[i];
            count = 1;
        }
    }

    if(st == extension[extension.size() - 1]) {
        cout << st << ' ' << count + 1 << '\n';
    }
    else {
        cout << st << ' ' << count << '\n';
        cout << extension[extension.size() - 1] << ' ' << 1 << '\n';
    }


    return 0;
}