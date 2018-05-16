def c361e(test_str):
    initial_results={}
    for char in set(test_str.lower()):
        initial_results[char]=test_str.count(char)-test_str.count(char.upper())
    results=[(k,initial_results[k]) for k in sorted(initial_results, key=initial_results.get,reverse=True)]
    return results
