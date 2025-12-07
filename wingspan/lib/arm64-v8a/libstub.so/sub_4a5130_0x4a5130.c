// 函数: sub_4a5130
// 地址: 0x4a5130
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (zx.d(*(arg1 + 0x1c)) != 0)
    return 

int64_t* x21_1 = *(arg1 + 0x10)
*(arg1 + 0x1c) = 1
int32_t x23_1 = *(arg1 + 0x18)
size_t x19_1 = arg1
void* x0_1 = (*(*x21_1 + 0x18))(x21_1)

while (zx.d(*(x0_1 + 8)) == 0xc)
    x21_1 = *(x0_1 + 0x10)
    int32_t x9_1 = *(x0_1 + 0x18)
    
    if (x9_1 s< x23_1)
        x23_1 = x9_1
    
    x0_1 = (*(*x21_1 + 0x18))(x21_1, arg2)

(*(*x21_1 + 0x20))(x21_1, arg2)
uint32_t x8_8 = zx.d(*(x21_1 + 0xa))

if (x8_8 == 0)
label_4a51f0:
    size_t x0_6 = __strlen_chk(" ", 2)
    
    if (x0_6 == 0)
        goto label_4a5258
    
    int64_t x8_11 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t bytes_6 = x8_11 + x0_6
    int64_t x0_7
    
    if (bytes_6 u>= x10_1)
        int64_t oldmem = *arg2
        int64_t bytes_3 = x10_1 << 1
        int64_t bytes
        
        bytes = bytes_3 u< bytes_6 ? bytes_6 : bytes_3
        
        arg2[2] = bytes
        x0_7 = realloc(oldmem, bytes)
        *arg2 = x0_7
        
        if (x0_7 == 0)
            sub_491944()
            noreturn
        
        x8_11 = arg2[1]
    else
        x0_7 = *arg2
    
    memcpy(x0_7 + x8_11, " ", x0_6)
    arg2[1] += x0_6
label_4a5258:
    uint32_t x8_14 = zx.d(*(x21_1 + 0xa))
    
    if (x8_14 == 0)
        goto label_4a52b4
    
    if (x8_14 != 2)
        goto label_4a5280
    
    if (((*(*x21_1 + 8))(x21_1, arg2) & 1) != 0)
        goto label_4a52b4
    
    goto label_4a5280

if (x8_8 == 2)
    if (((*(*x21_1 + 8))(x21_1, arg2) & 1) == 0)
        goto label_4a5258
    
    goto label_4a51f0

label_4a5280:
uint32_t x8_17 = zx.d(*(x21_1 + 0xb))

if (x8_17 == 0)
label_4a52b4:
    size_t x0_13 = __strlen_chk(0x451d41, 2)
    
    if (x0_13 != 0)
        int64_t x8_20 = arg2[1]
        int64_t x10_2 = arg2[2]
        int64_t bytes_7 = x8_20 + x0_13
        int64_t x0_14
        
        if (bytes_7 u>= x10_2)
            int64_t oldmem_1 = *arg2
            int64_t bytes_4 = x10_2 << 1
            int64_t bytes_1
            
            bytes_1 = bytes_4 u< bytes_7 ? bytes_7 : bytes_4
            
            arg2[2] = bytes_1
            x0_14 = realloc(oldmem_1, bytes_1)
            *arg2 = x0_14
            
            if (x0_14 == 0)
                sub_491944()
                noreturn
            
            x8_20 = arg2[1]
        else
            x0_14 = *arg2
        
        memcpy(x0_14 + x8_20, 0x451d41, x0_13)
        arg2[1] += x0_13
else if (x8_17 == 2 && ((*(*x21_1 + 0x10))(x21_1, arg2) & 1) != 0)
    goto label_4a52b4

void* const x21_3

if (x23_1 == 0)
    x21_3 = &data_452170
else
    x21_3 = &data_451fb2

arg1 = __strlen_chk(x21_3, 3)

if (arg1 == 0)
    *(x19_1 + 0x1c) = 0
    return 

int64_t x8_23 = arg2[1]
int64_t x10_3 = arg2[2]
int64_t bytes_8 = x8_23 + arg1
int64_t x0_17

if (bytes_8 u>= x10_3)
    int64_t oldmem_2 = *arg2
    int64_t bytes_5 = x10_3 << 1
    int64_t bytes_2
    
    bytes_2 = bytes_5 u< bytes_8 ? bytes_8 : bytes_5
    
    arg2[2] = bytes_2
    x0_17 = realloc(oldmem_2, bytes_2)
    *arg2 = x0_17
    
    if (x0_17 == 0)
        sub_491944()
        noreturn
    
    x8_23 = arg2[1]
else
    x0_17 = *arg2

memmove(x0_17 + x8_23, x21_3, arg1)
arg2[1] += arg1
*(x19_1 + 0x1c) = 0
