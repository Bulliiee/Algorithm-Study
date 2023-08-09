// 테트로미노
#include <iostream>

#define MAX 500

using namespace std;

int inputX, inputY; // size
int res = 0;
int paper[MAX][MAX];
pair<int, int> points[4]; // 테트로미노 모양에 알맞은 4개의 좌표

class TetroPoints {
private:
    int x, y;   // 현재 좌표

public:
    TetroPoints(int x, int y) {
        this->x = x;
        this->y = y;
    }
    
    // 각 테트로미노 모양에 맞는 좌표를 전역 points에 저장
    // 참이면 input크기 범위 안쪽
    // 가장 높은곳에서 가장 왼쪽을 기준점으로 함

    // ㅣ모양
    bool setTetro1_1() {
        if(this->y + 3 >= inputY) {
            return false;
        }

        for(int i = 0; i < 4; i++) {
            points[i] = make_pair(this->x, this->y + i);
        }
        
        return true;
    }
    bool setTetro1_2() {
        if(this->x + 3 >= inputX) {
            return false;
        }

        for(int i = 0; i < 4; i++) {
            points[i] = make_pair(this->x + i, this->y);
        }

        return true;
    }
    // ㅁ모양
    bool setTetro2() {
        if((this->x + 1 >= inputX) || (this->y + 1 >= inputY)) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x, this->y + 1);
        points[3] = make_pair(this->x + 1, this->y + 1);
        return true;
    }
    // L모양
    bool setTetro3_1() {
        if((this->x + 1 >= inputX) || (this->y + 2 >= inputY)) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x, this->y + 2);
        points[3] = make_pair(this->x + 1, this->y + 2);
        return true;
    }
    bool setTetro3_2() {
        if((this->x + 2 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x + 2, this->y);
        points[3] = make_pair(this->x, this->y + 1);
        return true;
    }
    bool setTetro3_3() {
        if((this->x + 1 >= inputX) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x + 1, this->y + 1);
        points[3] = make_pair(this->x + 1, this->y + 2);
        return true;
    }
    bool setTetro3_4() {
        if((this->x - 2 < 0) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x - 1, this->y + 1);
        points[3] = make_pair(this->x - 2, this->y + 1);
        return true;
    }
    bool setTetro3_5() {
        if((this->x - 1 < 0) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x, this->y + 2);
        points[3] = make_pair(this->x - 1, this->y + 2);
        return true;
    }
    bool setTetro3_6() {
        if((this->x + 2 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x + 1, this->y + 1);
        points[3] = make_pair(this->x + 2, this->y + 1);
        return true;
    }
    bool setTetro3_7() {
        if((this->x + 1 >= inputX) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x, this->y + 1);
        points[3] = make_pair(this->x, this->y + 2);
        return true;
    }
    bool setTetro3_8() {
        if((this->x + 2 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x + 2, this->y);
        points[3] = make_pair(this->x + 2, this->y + 1);
        return true;
    }
    // Z모양
    bool setTetro4_1() {
        if((this->x + 1 >= inputX) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x + 1, this->y + 1);
        points[3] = make_pair(this->x + 1, this->y + 2);
        return true;
    }
    bool setTetro4_2() {
        if((this->x - 1 < 0 || this->x + 1 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x - 1, this->y + 1);
        points[3] = make_pair(this->x + 1, this->y);
        return true;
    }
    bool setTetro4_3() {
        if((this->x - 1 < 0) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x - 1, this->y + 1);
        points[3] = make_pair(this->x - 1, this->y + 2);
        return true;
    }
    bool setTetro4_4() {
        if((this->x + 2 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x + 1, this->y + 1);
        points[3] = make_pair(this->x + 2, this->y + 1);
        return true;
    }
    // ㅗ모양
    bool setTetro5_1() {
        if((this->x + 2 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x + 1, this->y);
        points[2] = make_pair(this->x + 2, this->y);
        points[3] = make_pair(this->x + 1, this->y + 1);
        return true;
    }
    bool setTetro5_2() {
        if((this->x - 1 < 0) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x, this->y + 2);
        points[3] = make_pair(this->x - 1, this->y + 1);
        return true;
    }
    bool setTetro5_3() {
        if((this->x - 1 < 0 || this->x + 1 >= inputX) || this->y + 1 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x - 1, this->y + 1);
        points[3] = make_pair(this->x + 1, this->y + 1);
        return true;
    }
    bool setTetro5_4() {
        if((this->x + 1 >= inputX) || this->y + 2 >= inputY) {
            return false;
        }

        points[0] = make_pair(this->x, this->y);
        points[1] = make_pair(this->x, this->y + 1);
        points[2] = make_pair(this->x, this->y + 2);
        points[3] = make_pair(this->x + 1, this->y + 1);
        return true;
    }
};

int getAddTetro() {
    int temp = 0;
    for(int i = 0; i < 4; i++) {
        temp += paper[points[i].second][points[i].first];
    }

    return temp;
}

void tetromino() {
    int temp = 0;
    for(int i = 0; i < inputY; i++) {
        for(int j = 0; j < inputX; j++) {
            TetroPoints tp(j, i);
            if(tp.setTetro1_1()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro1_2()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro2()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_1()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_2()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_3()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_4()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_5()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_6()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_7()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro3_8()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro4_1()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro4_2()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro4_3()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro4_4()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro5_1()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro5_2()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro5_3()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
            if(tp.setTetro5_4()) {
                temp = getAddTetro();
                if(temp > res) { res = temp; }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> inputY >> inputX;
    for(int i = 0; i < inputY; i++) {
        for(int j = 0; j < inputX; j++) {
            cin >> paper[i][j];
        }
    }

    tetromino();

    cout << res;

    return 0;
}