pragma solidity ^0.5.0;

import "./Holdable.sol";

contract IXToken is Holdable {
    constructor (string memory name, string memory symbol, uint8 decimals, uint256 totalSupply) Holdable(name, symbol, decimals) public {
        _mint(_msgSender(), totalSupply);
    }
}