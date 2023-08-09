// 달달함이 넘쳐흘러
#include <iostream>

using namespace std;

class Cake {
private:
    int x, y, z;

public:
    Cake(int x, int y, int z);
    int getX();
    int getY();
    int getZ();
};

Cake::Cake(int x, int y, int z) {
    this->x = x;
    this->y = y;
    this->z = z;
}
int Cake::getX() { return this->x; }
int Cake::getY() { return this->y; }
int Cake::getZ() { return this->z; }

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // nullptr은 포인터를 표현하는 값 중에 null을 표현한 값이다.
    // 초기화 방법은 아래중 아무거나 사용
    Cake* a(nullptr);
    Cake* b = nullptr;
    Cake* c = {nullptr};
    int x, y, z;

    for(int i = 0; i < 2; i++) {
        cin >> x >> y >> z;
        // 포인터는 null이면 false리턴
        if(a == nullptr) {
            a = new Cake(x, y, z);
        }
        else {
            c = new Cake(x, y, z);
        }
    }

    // b케이크의 x, y, z구하기
    x = c->getX() - a->getZ();
    y = c->getY() / a->getY();
    z = c->getZ() - a->getX();

    b = new Cake(x, y, z);

    cout << b->getX() << ' ' << b->getY() << ' ' << b->getZ() << '\n';

    return 0;
}