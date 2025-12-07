// 函数: sub_45c638
// 地址: 0x45c638
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

arg2[3].b = (arg2 == arg1 ? 1 : 0).b

if (arg2 == arg1)
    return 

int64_t* x8_2

do
    void** x9_2 = arg2[2]
    
    if (zx.d(x9_2[3].b) != 0)
        break
    
    x8_2 = x9_2[2]
    void* x11_2 = *x8_2
    char* x11_1
    
    if (x11_2 == x9_2)
        void* x11_3 = x8_2[1]
        
        if (x11_3 != 0)
            x11_1 = x11_3 + 0x18
        
        if (x11_3 == 0 || zx.d(*x11_1) != 0)
            int64_t* x10_1
            
            if (*x9_2 == arg2)
                x10_1 = x9_2
            else
                x10_1 = x9_2[1]
                void* x11_4 = *x10_1
                x9_2[1] = x11_4
                
                if (x11_4 != 0)
                    *(x11_4 + 0x10) = x9_2
                    x8_2 = x9_2[2]
                
                x10_1[2] = x8_2
                int64_t* x8_3 = x9_2[2]
                x8_3[zx.q(*x8_3 != x9_2 ? 1 : 0)] = x10_1
                *x10_1 = x9_2
                x9_2[2] = x10_1
                x8_2 = x10_1[2]
            
            x10_1[3].b = 1
            void* x9_4 = *x8_2
            x8_2[3].b = 0
            void* x10_9 = *(x9_4 + 8)
            *x8_2 = x10_9
            
            if (x10_9 != 0)
                *(x10_9 + 0x10) = x8_2
            
            *(x9_4 + 0x10) = x8_2[2]
            int64_t* x10_11 = x8_2[2]
            x10_11[zx.q(*x10_11 != x8_2 ? 1 : 0)] = x9_4
            *(x9_4 + 8) = x8_2
            x8_2[2] = x9_4
            return 
    else
        if (x11_2 != 0)
            x11_1 = x11_2 + 0x18
        
        if (x11_2 == 0 || zx.d(*x11_1) != 0)
            if (*x9_2 == arg2)
                void* x10_3 = arg2[1]
                *x9_2 = x10_3
                
                if (x10_3 != 0)
                    *(x10_3 + 0x10) = x9_2
                    x8_2 = x9_2[2]
                
                arg2[2] = x8_2
                int64_t* x8_4 = x9_2[2]
                x8_4[zx.q(*x8_4 != x9_2 ? 1 : 0)] = arg2
                arg2[1] = x9_2
                x9_2[2] = arg2
                x8_2 = arg2[2]
            else
                arg2 = x9_2
            
            arg2[3].b = 1
            void** x9_3 = x8_2[1]
            x8_2[3].b = 0
            void* x10_6 = *x9_3
            x8_2[1] = x10_6
            
            if (x10_6 != 0)
                *(x10_6 + 0x10) = x8_2
            
            x9_3[2] = x8_2[2]
            int64_t* x10_8 = x8_2[2]
            x10_8[zx.q(*x10_8 != x8_2 ? 1 : 0)] = x9_3
            *x9_3 = x8_2
            x8_2[2] = x9_3
            return 
    
    x9_2[3].b = 1
    arg2 = x8_2
    x8_2[3].b = (x8_2 == arg1 ? 1 : 0).b
    *x11_1 = 1
while (x8_2 != arg1)
