// 函数: sub_49548c
// 地址: 0x49548c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x11_14 = *arg1
void* x9_1 = arg1[1]

if (x11_14 != x9_1)
    if (zx.d(*x11_14) == 0x68)
        void* x8_2 = &x11_14[1]
        *arg1 = x8_2
        void* x10_2
        void* x11_2
        
        if (x8_2 == x9_1)
            x10_2 = x9_1
            
            if (x8_2 == x9_1 || zx.d(*x10_2) - 0x30 u> 9)
                x8_2 = nullptr
                x11_2 = nullptr
            else
            label_495580:
                void* x10_5 = x10_2 + 1
                
                while (true)
                    *arg1 = x10_5
                    
                    if (x9_1 == x10_5)
                        x10_2 = x9_1
                        x11_2 = x9_1
                        break
                    
                    uint32_t x11_3 = zx.d(*x10_5)
                    x10_5 += 1
                    
                    if (x11_3 - 0x30 u>= 0xa)
                        x10_2 = x10_5 - 1
                        x11_2 = x10_2
                        break
        else
            void* x12_1 = x8_2
            x10_2 = x8_2
            
            if (zx.d(*x8_2) == 0x6e)
                x10_2 = &x11_14[2]
                x12_1 = x10_2
                *arg1 = x10_2
            
            if (x12_1 != x9_1 && zx.d(*x10_2) - 0x30 u<= 9)
                goto label_495580
            
            x8_2 = nullptr
            x11_2 = nullptr
        
        if (x8_2 == x11_2 || x10_2 == x9_1)
            return 1
        
        if (zx.d(*x10_2) == 0x5f)
            *arg1 = x10_2 + 1
            return 0
    else if (zx.d(*x11_14) == 0x76)
        void* x8_4 = &x11_14[1]
        *arg1 = x8_4
        void* x10_4
        void* x11_7
        
        if (x8_4 == x9_1)
            x10_4 = x9_1
            
            if (x8_4 == x9_1 || zx.d(*x10_4) - 0x30 u> 9)
                x8_4 = nullptr
                x11_7 = nullptr
            else
            label_495634:
                void* x10_6 = x10_4 + 1
                
                while (true)
                    *arg1 = x10_6
                    
                    if (x9_1 == x10_6)
                        x10_4 = x9_1
                        x11_7 = x9_1
                        break
                    
                    uint32_t x11_10 = zx.d(*x10_6)
                    x10_6 += 1
                    
                    if (x11_10 - 0x30 u>= 0xa)
                        x10_4 = x10_6 - 1
                        x11_7 = x10_4
                        break
        else
            void* x12_2 = x8_4
            x10_4 = x8_4
            
            if (zx.d(*x8_4) == 0x6e)
                x10_4 = &x11_14[2]
                x12_2 = x10_4
                *arg1 = x10_4
            
            if (x12_2 != x9_1 && zx.d(*x10_4) - 0x30 u<= 9)
                goto label_495634
            
            x8_4 = nullptr
            x11_7 = nullptr
        
        if (x8_4 == x11_7 || x10_4 == x9_1)
            return 1
        
        if (zx.d(*x10_4) == 0x5f)
            void* x8_8 = x10_4 + 1
            *arg1 = x8_8
            void* x11_9
            void* x12_5
            
            if (x8_8 == x9_1)
                x11_9 = x9_1
                x12_5 = x8_8
            else
                x12_5 = x8_8
                x11_9 = x8_8
                
                if (zx.d(*x8_8) == 0x6e)
                    x11_9 = x10_4 + 2
                    x12_5 = x11_9
                    *arg1 = x11_9
            
            void* x10_9
            
            if (x12_5 == x9_1 || zx.d(*x11_9) - 0x30 u> 9)
                x8_8 = nullptr
                x10_9 = nullptr
            else
                void* x10_10 = x11_9 + 1
                
                while (true)
                    *arg1 = x10_10
                    
                    if (x9_1 == x10_10)
                        x11_9 = x9_1
                        x10_9 = x9_1
                        break
                    
                    uint32_t x11_12 = zx.d(*x10_10)
                    x10_10 += 1
                    
                    if (x11_12 - 0x30 u>= 0xa)
                        x11_9 = x10_10 - 1
                        x10_9 = x11_9
                        break
            
            if (x8_8 == x10_9 || x11_9 == x9_1)
                return 1
            
            if (zx.d(*x11_9) == 0x5f)
                *arg1 = x11_9 + 1
                return 0

return 1
