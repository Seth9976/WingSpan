// 函数: sub_49c60c
// 地址: 0x49c60c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = arg1[1]
int64_t* x19 = arg1

if (x8 == arg1[2])
    int64_t oldmem = *x19
    size_t x21_1 = x8 - oldmem
    int64_t* x22_1
    
    if (&x19[3] == oldmem)
        arg1 = malloc(x21_1 << 1)
        
        if (arg1 == 0)
            sub_491944()
            noreturn
        
        x22_1 = arg1
        
        if (x21_1 != 0)
            memmove(x22_1, oldmem, x21_1)
        
        *x19 = x22_1
    else
        arg1 = realloc(oldmem, x21_1 << 1)
        x22_1 = arg1
        *x19 = arg1
        
        if (arg1 == 0)
            sub_491944()
            noreturn
    
    x8 = x22_1 + x21_1
    x19[1] = x8
    x19[2] = &x22_1[x21_1 s>> 2]

int64_t x9_5 = *arg2
x19[1] = x8 + 8
*x8 = x9_5
