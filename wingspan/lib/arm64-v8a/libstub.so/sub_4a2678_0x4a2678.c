// 函数: sub_4a2678
// 地址: 0x4a2678
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
char* x0

if (x8 + 1 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_3 = x10 << 1
    size_t bytes
    
    if (bytes_3 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_3
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a26cc
else
    x0 = *arg2
label_4a26cc:
    x0[x8] = 0x3c
    arg2[1] += 1
    sub_49cc90(arg1 + 0x10, arg2)
    void* x8_3 = arg2[1]
    
    if (x8_3 == 0)
        goto label_4a2748
    
    char* oldmem_1 = *arg2
    
    if (zx.d(*(x8_3 + oldmem_1 - 1)) != 0x3e)
        goto label_4a2748
    
    int64_t x10_1 = arg2[2]
    
    if (x8_3 + 1 u< x10_1)
        goto label_4a2738
    
    int64_t bytes_4 = x10_1 << 1
    void* bytes_1
    
    if (bytes_4 u< x8_3 + 1)
        bytes_1 = x8_3 + 1
    else
        bytes_1 = bytes_4
    
    arg2[2] = bytes_1
    oldmem_1 = realloc(oldmem_1, bytes_1)
    *arg2 = oldmem_1
    
    if (oldmem_1 != 0)
        x8_3 = arg2[1]
    label_4a2738:
        *(oldmem_1 + x8_3) = 0x20
        x8_3 = arg2[1] + 1
        arg2[1] = x8_3
    label_4a2748:
        int64_t x10_2 = arg2[2]
        char* result
        
        if (x8_3 + 1 u< x10_2)
            result = *arg2
        label_4a2788:
            *(result + x8_3) = 0x3e
            arg2[1] += 1
            return result
        
        int64_t oldmem_2 = *arg2
        size_t bytes_5 = x10_2 << 1
        size_t bytes_2
        
        if (bytes_5 u< x8_3 + 1)
            bytes_2 = x8_3 + 1
        else
            bytes_2 = bytes_5
        
        arg2[2] = bytes_2
        result = realloc(oldmem_2, bytes_2)
        *arg2 = result
        
        if (result != 0)
            x8_3 = arg2[1]
            goto label_4a2788
sub_491944()
noreturn
