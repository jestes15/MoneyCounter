#include <jni.h>
#include <string>
#include <cmath>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_moneycounter_MainActivity_stringFromJNI(JNIEnv* env, jobject) {
    std::string hello = "Input the amount of bills/coins you have into the\nboxes below!";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_moneycounter_MainActivity_calculateMoney(JNIEnv* env, jobject, jdouble other,
                                                          jdouble twenties, jdouble tens, jdouble fives,
                                                          jdouble ones, jdouble quarters, jdouble dimes,
                                                          jdouble nickles, jdouble pennies) {
    return other + (twenties * 20) + (tens * 10) + (fives * 5) + ones +
           (.25 * quarters) + (.1 * dimes) + (.05 * nickles) + (.01 * pennies);
}