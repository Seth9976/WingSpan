// 函数: sub_490b60
// 地址: 0x490b60
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x9 = *(x23 + 0x28)
int128_t v0 = *(&data_4abb90 + (sx.q(arg3) ^ 0x14) * 0x18)
int32_t x8_3 = (*((sx.q(arg3) ^ 0x14) * 0x18 + 0x4abba0)).d
int64_t x0 = (*(*arg1 + 0x30))(arg1, v0.q)
int64_t x20 = v0:8.q
int64_t x21 = sx.q(x8_3)
(*(*arg1 + 0x6b8))(arg1, x0, x20, zx.q(x21.d))
(*(*arg1 + 0xb8))(arg1, x0)
int64_t result = memset(x20, 0, x21 * 0x18)

if (*(x23 + 0x28) == x9)
    return result

__stack_chk_fail()
noreturn
