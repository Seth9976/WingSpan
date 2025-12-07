// 函数: sub_45cb18
// 地址: 0x45cb18
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x22_1 = &arg1[1]
int64_t* x23 = *x22_1
int64_t* result

if (x23 == 0)
    x23 = x22_1
label_45cbc4:
    result = *x22_1
    
    if (result == 0)
    label_45cbe4:
        int64_t* result_1
        int128_t v0_1
        result_1, v0_1 = sub_4914a0(0x40)
        int128_t* x8_2 = *arg4
        result = result_1
        int64_t x9_2 = x8_2[1].q
        v0_1 = *x8_2
        *result_1 = 0
        result_1[1] = 0
        result_1[2] = x23
        result_1[6] = x9_2
        result_1[7] = 0
        *(result_1 + 0x20) = v0_1
        *x22_1 = result_1
        int64_t x8_4 = **arg1
        int64_t* result_2
        
        if (x8_4 == 0)
            result_2 = result
        else
            *arg1 = x8_4
            result_2 = *x22_1
        
        sub_45c638(arg1[1], result_2)
        arg1[2] += 1
    
    return result

int64_t x8_1 = *arg2
int64_t x9_1 = arg2[1]
int64_t x10_1 = arg2[2]
x22_1 = &arg1[1]

while (true)
    int64_t x11_1 = x23[4]
    
    if (x8_1 == x11_1)
        int64_t x11_2 = x23[5]
        
        if (x9_1 != x11_2)
            if (x9_1 u< x11_2)
                goto label_45cb90
            
            if (x11_2 u>= x9_1)
                goto label_45cbc4
            
            goto label_45cbb0
        
        int64_t x11_3 = x23[6]
        
        if (x10_1 u< x11_3)
            goto label_45cb90
        
        if (x11_3 u>= x10_1)
            goto label_45cbc4
        
    label_45cbb0:
        x22_1 = &x23[1]
        int64_t* x11_5 = *x22_1
        
        if (x11_5 == 0)
            goto label_45cbc4
        
        x23 = x11_5
    else
        if (x8_1 u>= x11_1)
            if (x11_1 u>= x8_1)
                goto label_45cbc4
            
            goto label_45cbb0
        
    label_45cb90:
        int64_t* x11_4 = *x23
        
        if (x11_4 == 0)
            x22_1 = x23
            result = *x22_1
            
            if (result != 0)
                return result
            
            break
        
        x22_1 = x23
        x23 = x11_4

goto label_45cbe4
