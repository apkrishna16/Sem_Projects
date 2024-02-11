import typing
from collections import Counter
from itertools import accumulate
from typing import List

weights_list = [57, 71, 87, 97, 99, 101, 103, 113, 114,
                 115, 128, 129, 131, 137, 147, 156, 163, 186]
weights_dict = {57: "G", 71: "A", 87: "S", 97: "P", 99: "V", 101: "T", 103:"C",
                113: "I/L", 114: "N", 115: "D", 128: "K/Q", 129: "E", 131: "M",
                137: "H", 147: "F", 156: "R", 163: "Y", 186: "W"}

    
# reads the dataset file
def read_file(data_file):
    with open(data_file, mode='r', encoding='utf-8') as f:
        data = f.read()
    data = data.split('\n')
    N = int(data[0].strip())
    Spectrum = Counter([int(w) for w in data[1].strip().split()])
    return Spectrum, N

# funtion to convert the weights into amino acids
def amino_acids(LeaderPeptide):
    temp_list = []
    for weight in LeaderPeptide:
        temp_list.append(weights_dict[weight])
    peptide = ' '.join([str(i) for i in temp_list])
    return peptide

# function to expand the leaderboard
def expand(Leaderboard):
    new_leaderboard = []
    for peptide in Leaderboard:
        for weight in weights_list:
            new_peptide = peptide[:]
            new_peptide.append(weight)
            new_leaderboard.append(new_peptide)
    Leaderboard = new_leaderboard
    return Leaderboard

# function to calculate the mass of peptide
def mass(peptide):
    return sum(peptide)

# function to calculate the mass of expected peptide
def parent_mass(Spectrum):
    return max(Spectrum.elements())

# function to calculate the score of the peptide
def score(peptide: typing.Counter[int], Spectrum: typing.Counter[int]) -> int: 
    keys = peptide.keys() | Spectrum.keys() 
    return sum([min(peptide[k], Spectrum[k]) for k in keys])

# function to get the linear peptide spectrum
def peptide_spectrum(peptide: List[int]) -> typing.Counter[int]:  
    peptide_spectrum = Counter([0])
    for i in range(len(peptide)):
        peptide_spectrum += Counter(list(accumulate([weight for weight in peptide[i:]]))) 
    return peptide_spectrum

# function to trim the leaderboard
def trim(Leaderboard: List[List[int]], Spectrum: typing.Counter[int], N: int) -> List[List[int]]: 
    if len(Leaderboard) == 0:
        return Leaderboard
    scores = [score(peptide_spectrum(peptide), Spectrum) for peptide in Leaderboard]
    sorted_peptides_and_scores = list(sorted(zip(Leaderboard, scores), key=lambda x: x[1], reverse=True))
    for j in range(N + 1, len(sorted_peptides_and_scores)):
        if sorted_peptides_and_scores[j][1] < sorted_peptides_and_scores[N][1]:
            return [peptide for peptide, _ in sorted_peptides_and_scores[:j-1]]
    return [peptide for peptide, _ in sorted_peptides_and_scores]

# function for Leaderboard Cyclopeptide Sequencing
def Leaderboard_Cyclopeptide_Sequencing(Spectrum, N):
    Leaderboard = [[]]
    LeaderPeptide = next(iter(Leaderboard))
    while len(Leaderboard) > 0:
        Leaderboard = expand(Leaderboard)
        temp_leaderboard = []
        for peptide in Leaderboard:
            if mass(peptide) == parent_mass(Spectrum):
                if score(Counter(peptide), Spectrum) > score(Counter(LeaderPeptide), Spectrum):
                    LeaderPeptide = peptide
            elif mass(peptide) > parent_mass(Spectrum):
                continue
            temp_leaderboard.append(peptide)
        Leaderboard = temp_leaderboard
        Leaderboard = trim(Leaderboard, Spectrum, N)
    return LeaderPeptide


file = input('Enter file path: ')
Spectrum, N = read_file(file)
LeaderPeptide = Leaderboard_Cyclopeptide_Sequencing(Spectrum, N)
peptide =  amino_acids(LeaderPeptide)
result = '-'.join([str(i) for i in LeaderPeptide])
print(peptide)
print(result)
