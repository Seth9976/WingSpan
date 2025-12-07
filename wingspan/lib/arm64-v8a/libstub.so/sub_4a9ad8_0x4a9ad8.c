// 函数: sub_4a9ad8
// 地址: 0x4a9ad8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char x0_1 = (zx.q(*(arg1 + 0x20)) u>> 3).b & 0xff
uint32_t x21 = zx.d(x0_1)
void* x19 = arg3
int64_t* x26 = sub_4a9014(x0_1, arg1)
void* result = nullptr

while (*x19 != 0)
    int32_t x1_2 = *(x19 + 4)
    void* result_1 = result
    
    if (x1_2 != 0)
        if ((zx.d(*(arg1 + 0x20)) & 4) != 0)
            result_1 = x19 + 4 - sx.q(x1_2)
            
            if (result_1 != result)
                uint32_t x0_4 = sub_4a9254(result_1)
                x21 = x0_4
                x26 = sub_4a9014(x0_4.b, arg1)
        
        if (x21 != 0)
            uint8_t x27_1 = x21.b
            int64_t var_8
            sub_4a90d4(x27_1, x26, x19 + 8, &var_8)
            uint64_t x0_10 = zx.q(sub_4a8fb4(x27_1))
            int64_t x1_5 = -1
            
            if (x0_10 u<= 7)
                x1_5 = (1 << x0_10 << 3) - 1
            
            if ((x1_5 & var_8) != 0)
                goto label_4a9bc0
        else if (*(x19 + 8) != 0)
        label_4a9bc0:
            void* x0_12 = *arg2
            
            if (x0_12 != 0)
                int64_t x1_8 = *(x0_12 + 8)
                *(x0_12 + 8) = x1_8 + 1
                *(x0_12 + ((x1_8 + 2) << 3)) = x19
    
    x19 += zx.q(*x19) + 4
    result = result_1

return result
