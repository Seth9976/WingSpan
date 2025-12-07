// 函数: sub_4a6d44
// 地址: 0x4a6d44
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = *(arg2 + 0x10)

if ((arg6 & 1) != 0)
    if (arg1 == x8)
        goto label_4a6d98
    
    if (strcmp(*(arg1 + 8), *(x8 + 8)).d == 0)
        goto label_4a6d98
else if (*(arg1 + 8) == *(x8 + 8))
label_4a6d98:
    int64_t x9_2 = *(arg2 + 8)
    *(arg2 + 0x4d) = 1
    
    if (x9_2 == arg4)
        int64_t x9_3 = *(arg2 + 0x20)
        *(arg2 + 0x4c) = 1
        
        if (x9_3 == 0)
            *(arg2 + 0x20) = arg3
            *(arg2 + 0x30) = arg5
            *(arg2 + 0x3c) = 1
            
            if (arg5 == 1)
            label_4a6e20:
                int32_t x8_5 = *(arg2 + 0x48)
                
                if (x8_5 == 1)
                    *(arg2 + 0x4e) = x8_5.b
        else if (x9_3 == arg3)
            int32_t x8_4 = *(arg2 + 0x30)
            
            if (x8_4 == 2)
                x8_4 = arg5
                *(arg2 + 0x30) = arg5
            
            if (x8_4 == 1)
                goto label_4a6e20
        else
            int32_t x8_2 = *(arg2 + 0x3c)
            *(arg2 + 0x4e) = 1
            *(arg2 + 0x3c) = x8_2 + 1
