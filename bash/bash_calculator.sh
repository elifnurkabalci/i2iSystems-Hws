#!/bin/bash

echo "Welcome to the calculator script!"

# Function to calculate factorial
function factorial {
    if (( $1 == 0 )); then
        echo 1
    else
        echo $(( $1 * $(factorial $(( $1 - 1 ))) ))
    fi
}

# Ask for the calculation operand
echo "Input calculation operand"
read operand

# Check if the operand is valid
case $operand in
    + | - | '*' | / | %)
        # Ask for two numbers
        echo "Input number1"
        read num1
        echo "Input number2"
        read num2

        # Perform the operation
        result=$((num1 $operand num2))
        ;;
    !)
        # Ask for one number for factorial
        echo "Input number for factorial"
        read num

        # Perform the factorial operation
        result=$(factorial $num)
        ;;
    *)
        echo "Invalid operand. Please enter a valid operand."
        exit 1
        ;;
esac

# Displaying the result with a 2-second wait
echo "Calculating..."
sleep 2
echo "Result: $result"
