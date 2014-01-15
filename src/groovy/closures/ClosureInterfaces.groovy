// losureInterfaces

// a readable puts chars into a CharBuffer and returns the count of chars added
def readable = { it.put("12 34".reverse()); 5 } as Readable

// the Scanner constructor can take a Readable
def s = new Scanner(readable)
assert s.nextInt() == 43

println s.nextInt() 
