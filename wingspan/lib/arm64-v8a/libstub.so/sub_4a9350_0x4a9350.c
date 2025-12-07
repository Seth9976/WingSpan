// 函数: sub_4a9350
// 地址: 0x4a9350
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char x0_1 = (zx.q(*(arg1 + 0x20)) u>> 3).b & 0xff
int32_t* result = arg2
uint32_t x21 = zx.d(x0_1)
int64_t* x27 = sub_4a9014(x0_1, arg1)
void* x0_3 = nullptr

while (*result != 0)
    int32_t x1_2 = result[1]
    void* x20_1
    
    if (x1_2 == 0)
        x20_1 = x0_3
    else
        x20_1 = x0_3
        
        if ((zx.d(*(arg1 + 0x20)) & 4) != 0)
            x20_1 = &result[1] - sx.q(x1_2)
            
            if (x20_1 != x0_3)
                uint32_t x0_5 = sub_4a9254(x20_1)
                x21 = x0_5
                x27 = sub_4a9014(x0_5.b, arg1)
        
        int64_t var_10
        int64_t var_8
        
        if (x21 != 0)
            uint8_t x28_1 = x21.b
            sub_4a90d4(x21.b & 0xf, nullptr, sub_4a90d4(x28_1, x27, &result[2], &var_10), &var_8)
            uint64_t x0_16 = zx.q(sub_4a8fb4(x28_1))
            int64_t x1_7 = -1
            
            if (x0_16 u<= 7)
                x1_7 = (1 << x0_16 << 3) - 1
            
            if ((x1_7 & var_10) != 0)
                goto label_4a9408
        else
            int64_t x0_7 = *(result + 8)
            int64_t x1_4 = *(result + 0x10)
            var_10 = x0_7
            var_8 = x1_4
            
            if (x0_7 != 0)
            label_4a9408:
                
                if (arg3 - var_10 u< var_8)
                    return result
    
    result += zx.q(*result) + 4
    x0_3 = x20_1

return nullptr
