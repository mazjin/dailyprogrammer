PROGRAM challenge224
IMPLICIT NONE
character(len=20) :: ch
CHARACTER(LEN=20),DIMENSION(:), ALLOCATABLE :: list,shufflist
INTEGER :: count,pos,shuffpos

write(*,*) 'Welcome to The Shuffler. How many items will you be entering?'
read(*,*) count
ALLOCATE(list(count))
DO pos=1,count
	write(*,*) 'Please enter the item in position ',pos,' on the list.'
	read(*,*) list(pos)
END DO
write(*,*) 'Items 1 through ',count,' entered successfully.'
write (*,*) 'List is as follows:'
DO pos=1,count
	write(*,*) list(pos)
end do

!null check
!if (trim(ch)=='') then 
!	write(*,*) 'Null check worked.'
!else
!	write(*,*) 'Inaccurate null check, rewrite.'
!end if
ALLOCATE(shufflist(count))
do pos=1,count
	shufflist(pos)=" "
end do
write (*,*) 'Shuffling...'
do pos=1,count
	shuffpos=nint(count*RAND(0))
	!write(*,*) shuffpos
	do 
		if (shufflist(shuffpos)=="                   ") then
			shufflist(shuffpos)=list(pos)
			exit
		end if
		shuffpos=nint(count*RAND(0))
		!write(*,*) shuffpos
	end do
end do
write(*,*) 'Done! Shuffled list:'
do pos=1,count
	write(*,*) shufflist(pos)
end do
write(*,*) 'Goodbye!'
END PROGRAM	
