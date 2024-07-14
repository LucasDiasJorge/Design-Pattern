#include <stdio.h>
#include <stdlib.h>

typedef struct Observer {
    void (*update)(struct Observer*);
    struct Observer* next;
} Observer;

typedef struct {
    Observer* head;
    int state;
} Subject;

void attach(Subject* subject, Observer* observer) {
    observer->next = subject->head;
    subject->head = observer;
}

void notify(Subject* subject) {
    Observer* observer = subject->head;
    while (observer != NULL) {
        observer->update(observer);
        observer = observer->next;
    }
}

void updateObserverA(Observer* self) {
    printf("Observer A notified\n");
}

void updateObserverB(Observer* self) {
    printf("Observer B notified\n");
}

int main() {
    Subject subject = {NULL, 0};
    
    Observer observerA = {updateObserverA, NULL};
    Observer observerB = {updateObserverB, NULL};
    
    attach(&subject, &observerA);
    attach(&subject, &observerB);
    
    subject.state = 1;
    notify(&subject);
    
    return 0;
}
