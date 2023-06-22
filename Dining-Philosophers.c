#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <time.h>
#include <pthread.h>

int philos[5] = {0,1,2,3,4};
enum {THINKING, HUNGRY, EATING} state[5];
pthread_mutex_t  mutex;
pthread_cond_t condVar;
int test(int philo_id)
{
    if((state[philo_id + 4 % 5] != EATING) && (state[philo_id] == HUNGRY) && (state[philo_id + 1 % 5] != EATING))
    {
        state[philo_id] = EATING;
        sleep((rand() % 4));
        printf("philospher %d is eating \n" , philo_id);
        //signal
        pthread_cond_signal(&condVar);
        return 1;
    }
    return 0;
}
void Return_Forks(int philo_id)
{
    pthread_mutex_lock(&mutex);
    state[philo_id] = THINKING;
    printf("philosopher %d is thinking \n", philos[philo_id]);
    test((philo_id + 4) % 5);
    test((philo_id + 1) % 4);
    pthread_mutex_unlock(&mutex);
}
void Pickup_Forks(int philo_id)
{
    pthread_mutex_lock(&mutex);
    state[philo_id] = HUNGRY;
    printf("philosopher %d is hungry \n", philos[philo_id]);
    if(!test(philo_id))
    {
        pthread_cond_wait(&condVar, &mutex);
    }
    pthread_mutex_unlock(&mutex);
}
// thread function
void* philosoper(void* arg)
{
    int i = 0;
    while(i < 1)
    {
        int* who_ptr = arg;
        int who = *who_ptr;
        sleep(1);
        Pickup_Forks(who);
        sleep(1);
        Return_Forks(who);
        i++;
    }
}

int main(int argc, char* argv[])
{
    //thread id
    pthread_t tid[5];

    //create attributes
    pthread_attr_t attr;
    //pthread_attr_init(&attr);
    pthread_mutex_init(&mutex,NULL);
    pthread_cond_init(&condVar,NULL);
    int i;
    for(i = 0; i < 5; i++)
    {
        pthread_create(&tid[i], NULL, philosoper, &philos[i]);
        //printf("philospher %d is thinking \n", i);
    }
    for(i = 0; i < 5; i++)
    {
    pthread_join(tid[i],NULL);
    }

    pthread_mutex_destroy (&mutex); 
    pthread_cond_destroy(&condVar);
    return 0;
    
    }