// 函数: sub_4a23f4
// 地址: 0x4a23f4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x8_1 = zx.q(*(arg1 + 0xc))
uint8_t* const x9 = &jump_table_4532de
char const* const result = "allocator"
uint64_t x11
bool z
bool cond:3

switch (x11)
    case 0
        return "basic_string"
    case 4
        return "string"
    case 8
        return "istream"
    case 0xc
        return "ostream"
    case 0x10
        return "iostream"
    case 0x13
        return result
    case 0x30
        if (not(z))
            goto label_4a24e0
        
        x8_1 = 0
        (*"ize")[0].d = 0
        __builtin_strncpy("getMethod", "e ar", 4)
        bool cond:2 = true
    label_4a2520:
        
        if (cond:2)
            goto label_4a24f0
        
        return nullptr
    case 0x31
    label_4a24e0:
        x8_1 = 0x657a69
    label_4a24e4:
        x9 = 0x2079617272612065
    label_4a24e8:
        bool cond:0 = x9 u<= x8_1
    label_4a24ec:
        
        if (cond:0)
            return nullptr
        
        goto label_4a24f0
    case 0x32
        goto label_4a24e4
    case 0x33
        goto label_4a24e8
    case 0x34
        goto label_4a24ec
    case 0x35
    label_4a24f0:
        x9 = 0x7669746167656e00
    label_4a24f4:
        result = *(x9 + (x8_1 << 3))
    label_4a24f8:
        x8_1 = zx.q(result[0xa])
    label_4a24fc:
        bool cond:1 = x8_1.d != 2
    label_4a2500:
        
        if (not(cond:1))
            jump(*(*result + 8))
        
        return zx.q(x8_1.d == 0 ? 1 : 0)
    case 0x36
        goto label_4a24f4
    case 0x37
        goto label_4a24f8
    case 0x38
        goto label_4a24fc
    case 0x39
        goto label_4a2500
    case 0x41
        goto label_4a2520
    case 0x42
        return nullptr
    case 0x43
        return result
    case 0x44
        return zx.q(x8_1.d == 0 ? 1 : 0)
    case 0x45
        return zx.q(cond:3 ? 1 : 0)
    case 0x46
        return result
    case 0x47
        return sub_4a2538("allocator", &data_4527e3[9]) __tailcall
    case 0x49
        if (z)
            goto label_4a2574
        
        x8_1 = 0x657a69
        x9 = 0x2079617272612065
    label_4a254c:
        bool cond:4 = x9 u<= x8_1
    label_4a2550:
        
        if (cond:4)
            return 0
        
        goto label_4a2554
    case 0x4c
        goto label_4a254c
    case 0x4d
        goto label_4a2550
    case 0x4e
    label_4a2554:
        x9 = 0x7669746167656e00
    label_4a2558:
        result = *(x9 + (x8_1 << 3))
    label_4a255c:
        x8_1 = zx.q(result[0xb])
    label_4a2560:
        bool cond:5 = x8_1.d != 2
    label_4a2564:
        
        if (cond:5)
            return zx.q(x8_1.d == 0 ? 1 : 0)
        
        goto label_4a2568
    case 0x4f
        goto label_4a2558
    case 0x50
        goto label_4a255c
    case 0x51
        goto label_4a2560
    case 0x52
        goto label_4a2564
    case 0x53
    label_4a2568:
        jump(*(*result + 0x10))
    case 0x54
        jump(*(x8_1 + 0x10))
    case 0x55
        jump(arg3)
    case 0x56
    label_4a2574:
        x9 = 0x2079617272612065
    label_4a2578:
        x8_1 = 0
        (*"ize")[0].d = 0
        (*"getMethod")[0].d = x9.d
        
        if (x9 u> 0)
            goto label_4a2554
        
        return 0
    case 0x57
        goto label_4a2578
    case 0x5f
        return result
    case 0x61
        bool cond:6 = x8_1.d == 0xffffffff
    label_4a25a4:
        
        if (cond:6)
            goto label_4a25cc
        
        goto label_4a25a8
    case 0x62
        goto label_4a25a4
    case 0x63
    label_4a25a8:
        x8_1 = 0x657a69
    label_4a25ac:
        x9 = 0x2079617272612065
    label_4a25b0:
        bool cond:7 = x9 u<= x8_1
    label_4a25b4:
        
        if (cond:7)
            return "allocator"
        
        goto label_4a25b8
    case 0x64
        goto label_4a25ac
    case 0x65
        goto label_4a25b0
    case 0x66
        goto label_4a25b4
    case 0x67
    label_4a25b8:
        x9 = 0x7669746167656e00
    label_4a25bc:
        jump(*(**(x9 + (x8_1 << 3)) + 0x18))
    case 0x68
        goto label_4a25bc
    case 0x69
        jump(*(*result + 0x18))
    case 0x6b
        jump(arg3)
    case 0x6c
    label_4a25cc:
        x9 = 0x2079617272612065
    label_4a25d0:
        x8_1 = 0
    label_4a25d4:
        (*"ize")[0].d = 0
        (*"getMethod")[0].d = x9.d
    label_4a25d8:
        bool cond:8 = x9 u> x8_1
    label_4a25dc:
        
        if (cond:8)
            goto label_4a25b8
        
        return "allocator"
    case 0x6d
        goto label_4a25d0
    case 0x6e
        goto label_4a25d4
    case 0x6f
        goto label_4a25d8
    case 0x70
        goto label_4a25dc
    case 0x72
        return sub_4a25e4("allocator", &data_4527e3[9]) __tailcall
    case 0x73
        bool cond:9 = x8_1.d == 0xffffffff
    label_4a25ec:
        
        if (not(cond:9))
            goto label_4a25f0
        
        (*"ize")[0].d = 0
        __builtin_strncpy("getMethod", "e ar", 4)
        jump(*(**(0x7669746167656e00 + (0 << 3)) + 0x20))
    case 0x74
        goto label_4a25ec
    case 0x75
    label_4a25f0:
        x8_1 = 0x657a69
    label_4a25f4:
        x9 = 0x2079617272612065
    label_4a25f8:
        bool cond:10 = x9 u<= x8_1
    label_4a25fc:
        
        if (cond:10)
            return "allocator"
        
        jump(*(**(0x7669746167656e00 + (x8_1 << 3)) + 0x20))
    case 0x76
        goto label_4a25f4
    case 0x77
        goto label_4a25f8
    case 0x78
        goto label_4a25fc
    case 0x79
        jump(*(**(0x7669746167656e00 + (x8_1 << 3)) + 0x20))
    case 0x7a
        jump(*(**(x9 + (x8_1 << 3)) + 0x20))
