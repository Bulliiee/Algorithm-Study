// Çà·Ä µ¡¼À
#include <iostream>

#define MAX 100

using namespace std;

int main() {
    int row, column;
    int arr[MAX][MAX], res[MAX][MAX];

    cin >> row >> column;
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < column; j++) {
            cin >> arr[i][j];
        }
    }

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < column; j++) {
            int temp;
            cin >> temp;
            res[i][j] = arr[i][j] + temp;
        }
    }

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < column; j++) {
            cout << res[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}