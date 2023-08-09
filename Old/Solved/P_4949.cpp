// 균형잡힌 세상
/* 스택으로 괄호 체크
    getline의 두 가지 형태

    std::istream::getline - cin.getline()
    getline(char* s, streamsize n, char delim);
    s: c언어처럼 문자열 받을 배열 가리키는 포인터
    n: 저장할 문자 최대 갯수
    delim: 제한자, 해당 문자 도달 시 추출 종료, 해당 문자는 s에 기록되지 않지만 스트림에서 사라짐
    제한자가 없을 경우 자동으로 개행문자(엔터)
    ex)
    char a[10];
    cin.getline(a, 10); // "hello lee" 입력
    cout << a;  // hello lee 출력

    std::getline(string)
    getline(istream& is, string& str, char delim);
    is: 입력 스트림 오브젝트 ex)cin
    str: 입력받은 문자열 저장할 string객체
    delim: 제한자, 해당 문자 도달 시 추출 종료, 해당 문자는 str에 기록되지 않지만 스트림에서 사라짐
    제한자가 없을 경우 자동으로 개행문자(엔터)
    ex)
    string a;
    getline(cin, a);    // "hello lee" 입력
    cout << a;  // hello lee 출력

    cin 사용 시(cin은 문자, 문자열 모두 입력 가능)
    char a[10];
    cin >> a;   // "hello lee" 입력
    cout << a;  // hello 출력
    위처럼 getline들과 다르게 띄어쓰기 시 컷 해버림

    get 사용 시(get은 문자만 입력 가능)
    char a, b, c;
    cin.get(a);
    cin.get(b);
    cin.get(c); // a b라고 입력
    cout << a << ' ' << b << ' ' << c; // a는 'a', b는 ' ', c는 b가 들어있음
    위처럼 띄어쓰기를 입력 종료가 아닌 입력받을 문자로 인식
*/
#include <iostream>
#include <string>
#include <stack>

using namespace std;

void balanced(string line, int length) {
    stack<char> bracketCheck;
    bool check = true; // t면 yes, f면 no

    for (int i = 0; i < line.length(); i++) {
        // 괄호 여는거면 스택에 바로 넣음
        if (line[i] == '(' || line[i] == '[') {
            bracketCheck.push(line[i]);
        }
        // 괄호 닫는 경우
        else if(line[i] == ')') {
            // 스택에 여는거 없는데 닫는거 나온 경우나 괄호 안맞으면 즉시 no
            if(bracketCheck.size() == 0 || bracketCheck.top() != '(') {
                check = false;
                break;
            }
            else {
                bracketCheck.pop();
            }
        }
        else if(line[i] == ']') {
            if(bracketCheck.size() == 0 || bracketCheck.top() != '[') {
                check = false;
                break;
            }
            else {
                bracketCheck.pop();
            }
        }
    }

    if(bracketCheck.size() == 0 && check) {
        cout << "yes" << '\n';
    }
    else {
        cout << "no" << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string line;

    // string의 length는 문자열의 길이, size는 메모리에서 실제로 사용하는 크기
    while(true) {
        getline(cin, line);
        // 그냥 점만 들어왔는지 체크
        if(line[0] == '.') {
            break;
        }
        // 한 라인 읽었지만 끝에가 점이 아니면 점 나올때까지 계속 읽어서 넣음
        while(line[line.length() - 1] != '.') {
            string temp;
            getline(cin, temp);
            line.append(temp);
        }


        balanced(line, line.length());
    }

    return 0;
}