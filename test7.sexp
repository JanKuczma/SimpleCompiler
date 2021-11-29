int main() {
  if (5 < 0) then { 44 }
  else { div(2094, 23, 55) }
}

int div(int n, int q, int tmp) {
  tmp := 0;
  repeat { n := (n - q); tmp := (tmp + 1) } until (n < 0);
  tmp
}