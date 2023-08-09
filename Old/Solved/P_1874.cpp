// 스택 수열
#include <iostream>
#include <stack>
#include <list>

using namespace std;

void makeSequence(list<int> seq, int input) {
    stack<int> st;
    string stackSeq = "";
    int count = 1;

    input *= 2;

    while(input--) {
        if(st.empty()) {
            st.push(count++);
            stackSeq.append("+\n");
            continue;
        }
        
        if(st.top() == seq.front()) {
            st.pop();
            seq.pop_front();
            stackSeq.append("-\n");
        }
        else {
            st.push(count++);
            stackSeq.append("+\n");
        }
    }

    if(seq.empty()) {
        cout << stackSeq;
    }
    else {
        cout << "NO" << '\n';
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    int temp;
    list<int> sequence;

    cin >> input;
    for(int i = 0; i < input; i++) {
        cin >> temp;
        sequence.push_back(temp);
    }

    makeSequence(sequence, input);

    return 0;
}