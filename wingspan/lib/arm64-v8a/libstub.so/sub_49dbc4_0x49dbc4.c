// 函数: sub_49dbc4
// 地址: 0x49dbc4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int128_t v0
v0.q = -1
v0:8.q = -1
int32_t x23 = arg2[3].d
int32_t x24 = *(arg2 + 0x1c)
arg2[3] = -1
int64_t* x21 = *(arg1 + 0x10)
int64_t x22 = arg2[1]
size_t result = (*(*x21 + 0x20))(x21, v0)

if (zx.d(*(x21 + 9)) != 1)
    result = (*(*x21 + 0x28))(x21, arg2)

int32_t x25 = *(arg2 + 0x1c)

if (x25 == 0xffffffff)
    result = __strlen_chk("...", 4)
    size_t result_1 = result
    
    if (result != 0)
        int64_t x8_5 = arg2[1]
        int64_t x10_1 = arg2[2]
        int64_t bytes_4 = x8_5 + result_1
        
        if (bytes_4 u>= x10_1)
            int64_t oldmem_1 = *arg2
            int64_t bytes_3 = x10_1 << 1
            int64_t bytes_1
            
            bytes_1 = bytes_3 u< bytes_4 ? bytes_4 : bytes_3
            
            arg2[2] = bytes_1
            int64_t x0_2 = realloc(oldmem_1, bytes_1)
            *arg2 = x0_2
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            result = memcpy(x0_2 + arg2[1], "...", result_1)
            arg2[1] += result_1
        else
            result = memcpy(*arg2 + x8_5, "...", result_1)
            arg2[1] += result_1
else if (x25 == 0)
    arg2[1] = x22
else if (x25 u>= 2)
    int32_t x26_1 = 1
    
    while (true)
        size_t x0_3 = __strlen_chk(0x452185, 3)
        
        if (x0_3 != 0)
            int64_t x8_6 = arg2[1]
            int64_t x10_2 = arg2[2]
            int64_t bytes_5 = x8_6 + x0_3
            int64_t x0_4
            
            if (bytes_5 u>= x10_2)
                int64_t oldmem = *arg2
                int64_t bytes_2 = x10_2 << 1
                int64_t bytes
                
                bytes = bytes_2 u< bytes_5 ? bytes_5 : bytes_2
                
                arg2[2] = bytes
                x0_4 = realloc(oldmem, bytes)
                *arg2 = x0_4
                
                if (x0_4 == 0)
                    break
                
                x8_6 = arg2[1]
            else
                x0_4 = *arg2
            
            memcpy(x0_4 + x8_6, 0x452185, x0_3)
            arg2[1] += x0_3
        
        arg2[3].d = x26_1
        int64_t* x22_2 = *(arg1 + 0x10)
        result = (*(*x22_2 + 0x20))(x22_2, arg2)
        
        if (zx.d(*(x22_2 + 9)) != 1)
            result = (*(*x22_2 + 0x28))(x22_2, arg2)
        
        x26_1 += 1
        
        if (x25 == x26_1)
            goto label_49dd84
    
    sub_491944()
    noreturn

label_49dd84:
arg2[3].d = x23
*(arg2 + 0x1c) = x24
return result
