// 괄호
// 나중에 큐로 푸는거 해보기
#include <iostream>

using namespace std;

class PS {
private:
    int leftIndex;
    int rightIndex;
public:
    PS();
    int getLeftIndex() {
        return leftIndex;
    }
    int getRightIndex() {
        return rightIndex;
    }
    void setLeftIndex(int index);
    void setRightIndex(int index);
    bool isVPS();
    void print();
};

PS::PS() {
    leftIndex = -1;
    rightIndex = -1;
}

void PS::setLeftIndex(int index) {
    this->leftIndex = index;
}

void PS::setRightIndex(int index) {
    this->rightIndex = index;
}

bool PS::isVPS() {
    if(leftIndex == -1 || rightIndex == -1) {
        return false;
    }
    else  {
        return true;
    }
}

void PS::print() {
    cout << leftIndex << ", " << rightIndex << '\n';
}

void vps(string st) {
    int length = st.length();

    if(length % 2 == 1) {
        cout << "NO" << '\n';
        return;
    }

    PS ps[length / 2];
    int index = 0;   // ps객체의 인덱스로 활용

    for(int i = 0; i < length; i++) {
        if(st[i] == '(') {
            // 인덱스 조절
            while(ps[index].getLeftIndex() != -1) {
                index++;
                if(index >= length / 2) {
                    cout << "NO" << '\n';
                    return;
                }
            }
            ps[index].setLeftIndex(i);
        }
        else {
            // 인덱스 조절
            while(ps[index].getRightIndex() != -1) {
                index--;
                if(index < 0) {
                    cout << "NO" << '\n';
                    return;
                }
            }
            // )(같은 경우 예외(leftIndex먼저 채우지않고 rightIndex채우는 경우)
            if(ps[index].getLeftIndex() == -1) {
                cout << "NO" << '\n';
                return;
            }
            ps[index].setRightIndex(i);
        }
    }

    // for(int i = 0; i < length / 2; i++) {
    //     ps[i].print();
    // }

    for(int i = 0; i < length / 2; i++) {
        if(!ps[i].isVPS()) {
            cout << "NO" << '\n';
            return;
        }
    }
    cout << "YES" << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string ps;
    int input;

    cin >> input;
    while(input--) {
        cin >> ps;

        vps(ps);
    }

    return 0;
}