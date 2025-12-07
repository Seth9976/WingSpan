// 函数: sub_4a6af4
// 地址: 0x4a6af4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = arg2[2]

if ((arg5 & 1) == 0)
    int64_t x9_1 = *(arg1 + 8)
    
    if (x9_1 == *(x8 + 8))
    label_4a6bd4:
        
        if (arg2[1] == arg3 && *(arg2 + 0x34) != 1)
            *(arg2 + 0x34) = arg4
    else if (x9_1 == *(*arg2 + 8))
    label_4a6b80:
        
        if (arg2[4] != arg3 && arg2[5] != arg3)
            int32_t x9_2 = *(arg2 + 0x3c)
            int32_t x8_7 = arg2[8].d
            arg2[7].d = arg4
            arg2[5] = arg3
            arg2[8].d = x8_7 + 1
            
            if (x9_2 == 1 && arg2[6].d == 2)
                *(arg2 + 0x4e) = 1
            
            *(arg2 + 0x44) = 4
        else if (arg4 == 1)
            arg2[7].d = 1
else
    if (arg1 == x8)
        goto label_4a6bd4
    
    int64_t x23_1 = *(arg1 + 8)
    
    if (strcmp(x23_1, *(x8 + 8)).d == 0)
        goto label_4a6bd4
    
    void* x8_1 = *arg2
    
    if (arg1 == x8_1)
        goto label_4a6b80
    
    if (strcmp(x23_1, *(x8_1 + 8)).d == 0)
        goto label_4a6b80
