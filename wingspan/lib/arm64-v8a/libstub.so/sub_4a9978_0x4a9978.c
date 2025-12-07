// 函数: sub_4a9978
// 地址: 0x4a9978
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int32_t* x19 = arg2
int64_t* x26 = nullptr
int32_t x25 = 0
int64_t result = 0
void* x1 = nullptr

while (*x19 != 0)
    int32_t x0_1 = x19[1]
    void* x21_2
    
    if (x0_1 == 0)
        x21_2 = x1
    else
        x21_2 = &x19[1] - sx.q(x0_1)
        
        if (x21_2 == x1)
            x21_2 = x1
        else
            int32_t x0_3 = sub_4a9254(x21_2)
            x25 = x0_3
            
            if (x0_3 == 0xff)
                return -1
            
            char x27_1 = x0_3.b
            x26 = sub_4a9014(x27_1, arg1)
            uint64_t x1_2 = zx.q(arg1[4].w)
            
            if ((x1_2.d & 0x7f8) == 0x7f8)
                arg1[4].w = (0xf807 & x1_2.w) | (zx.d(x27_1) << 3).w
            else if (((x1_2 u>> 3).d & 0xff) != x25)
                arg1[4].b |= 4
        
        char x27_2 = x25.b
        int64_t var_8
        sub_4a90d4(x27_2, x26, &x19[2], &var_8)
        uint64_t x0_13 = zx.q(sub_4a8fb4(x27_2))
        int64_t x1_6 = -1
        
        if (x0_13 u<= 7)
            x1_6 = (1 << x0_13 << 3) - 1
        
        int64_t x0_14 = var_8
        
        if ((x1_6 & x0_14) != 0)
            result += 1
            
            if (x0_14 u< *arg1)
                *arg1 = x0_14
    
    x1 = x21_2
    x19 += zx.q(*x19) + 4

return result
